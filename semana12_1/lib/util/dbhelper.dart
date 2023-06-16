import 'package:path/path.dart';
import 'package:sqflite/sqflite.dart';
import 'package:sqflite/sqlite_api.dart';
import 'package:semana12_1/models/shopping_list.dart';
import 'package:semana12_1/models/list_items.dart';

class DbHelper {
  final int version = 1 ;
  Database? db;
  //para que solo se cree/abra una instancia de la BD
  static final DbHelper dbHelper = DbHelper._internal();
  DbHelper._internal();
  factory DbHelper(){
    return dbHelper;
  }

  Future<Database> openDB() async{
    if(db ==null){
      db = await openDatabase(join(await getDatabasesPath(),
    'shopping.db_v4'),
    onCreate: (database, version){
        database.execute(
        'CREATE TABLE lists(id INTEGER PRIMARY KEY, name TEXT, priority INTEGER)');
        database.execute(
            'CREATE TABLE items(id INTEGER PRIMARY KEY, idList INTEGER,name TEXT, quantity TEXT, note TEXT, FOREIGN KEY(idList) REFERENCES lists(id))');

    }, version: version);
    }
    return db!;
  }

  //Probar el BD
  Future testDB() async{
    db = await openDB();

    await db!.execute('INSERT INTO lists Values(0,"Memorias", 1)');
    await db!.execute('INSERT INTO items Values(0, 0, "Memorias DDR4", "8 unds", "Marca Kignston")');

    List list = await db!.rawQuery('SELECT * FROM lists');
    List items = await db!.rawQuery('SELECT * FROM items');

    print(list[0]);
    print(items[0]);
  }
  Future<int> insertList(ShoppingList list) async{
    int id = await this.db!.insert('list', list.toMap(),
    conflictAlgorithm: ConflictAlgorithm.replace);
    return id;
  }
  Future<int> insertItem(ListItems item) async{
    int id = await this.db!.insert('item', item.toMap(),
        conflictAlgorithm: ConflictAlgorithm.replace);
    return id;
  }

  //Listar list
  Future<List<ShoppingList>> getLists() async{
      final List<Map<String,dynamic>> maps = await db!.query('lists');
      return List.generate(maps.length, (i) {
        return ShoppingList(
          maps[i]['id'],
          maps[i]['name'],
          maps[i]['priority'],
        );
      });
  }
}