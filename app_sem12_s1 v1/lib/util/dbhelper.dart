import 'package:app_sem12_s1/models/shopping_list.dart';
import 'package:sqflite/sqflite.dart';
import 'package:path/path.dart';

import '../models/item_list.dart';

class DbHelper {
  final int version =1;
  Database? db;

  static final DbHelper dbHelper = DbHelper._internal();
  DbHelper._internal();
  factory DbHelper(){
    return dbHelper;
  }

  Future<Database> openDB() async{
    if (db == null){
      db = await openDatabase(join(await getDatabasesPath(), 'shopping_v4.db'), onCreate: (database,version){
        database.execute('CREATE TABLE lists(id INTEGER PRIMARY KEY, name TEXT, priority INTEGER)');

        database.execute('CREATE TABLE items(id INTEGER PRIMARY KEY, idList INTEGER,'
            ' name TEXT, quantity TEXT, note TEXT, FOREING KEY(idList), REFERENCES lists(id))');
      }, version: version);

    }
    return db!;
  }

  Future TestTB() async{
    db = await openDB();

    await db!.execute('INSERT INTO lists VALUES (0,"Memorias", 1');
    await db!.execute('INSERT INTO items VALUES (0, 0,"Memorias DDR4", "8 unds.", "Marca Kingston"');

    List list = await db!.rawQuery('Select * FROM lists');
    List items = await db!.rawQuery('Select * FROM items');

    print(list[0]);
    print(items[0]);
  }

  Future<int> insertList(ShoppingList list) async {
    int id = await this.db!.insert('lists', list.toMap(),
    conflictAlgorithm: ConflictAlgorithm.replace);
    return id;
  }

  Future<int> insertItems(ListItem list) async {
    int id = await this.db!.insert('items', list.toMap());
    conflictAlgorithm : ConflictAlgorithm.replace;

    return id;
  }
  Future<List<ShoppingList>> getList() async{
    final List<Map<String, dynamic>> maps = await db!.query('lists');

    return List.generate(maps.length, (i){
      return ShoppingList(maps[i]['id'], maps[i]['name'], maps[i]['priority']);
    });
  }

  Future<List<ListItem>> getItems(int idList) async{
    final List<Map<String, dynamic>> maps = await db!.query('lists', where: 'idlist = ?',whereArgs: [idList]);

    return List.generate(maps.length, (i){
      return ListItem(
          maps[i]['id'],
          maps[i]['idList'],
          maps[i]['name'],
          maps[i]['quantity'],
          maps[i]['note'],
      );
    });
  }
}

