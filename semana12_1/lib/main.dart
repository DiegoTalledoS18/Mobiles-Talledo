import 'package:flutter/material.dart';
import 'package:semana12_1/ui/shopping_list_dialog.dart';
import 'package:semana12_1/util/dbhelper.dart';

import 'models/shopping_list.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    //DbHelper helper = DbHelper();
    //helper.testDB();
    return MaterialApp(
      theme:ThemeData(
        primarySwatch:  Colors.blue,
      ),
      home: ShowList(),
    );
  }
}

class ShowList extends StatefulWidget {
  const ShowList({Key? key}) : super(key: key);

  @override
  State<ShowList> createState() => _ShowListState();
}

class _ShowListState extends State<ShowList> {
  DbHelper helper = DbHelper();
  List<ShoppingList> shoppingList= [];

  ShoppingListDialog? dialog;
  @override
  void initState(){
    dialog=ShoppingListDialog();
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    showData();
    return Scaffold(
      body: ListView.builder(
        itemCount: (shoppingList != null)? shoppingList.length:0,
        itemBuilder: (BuildContext context, int index) {
          return ListTile(
            title: Text(shoppingList [index].name),
            leading: CircleAvatar(
              child: Text(shoppingList[index].priority.toString()),
            ), // CircleAvator
            trailing: IconButton(
              icon: Icon(Icons.edit),
              onPressed: () {
                showDialog(
                    context: context,
                    builder: (BuildContext context) => dialog!.buildDialog(
                            context, shoppingList[index], false));
              },
            ),
          );
        }),
        floatingActionButton: FloatingActionButton (
          onPressed: (){
            showDialog(
              context: context,
              builder: (BuildContext context) => dialog!.buildDialog(
                  context, ShoppingList(0, '', 0), true));
          },
          child: Icon(Icons.plus_one),
          backgroundColor: Colors.orangeAccent,
        ),
    );
  }
  Future showData() async{
    await helper.openDB();
    shoppingList = await helper.getLists();
    setState(() {
      shoppingList = shoppingList;
    });
  }
}
