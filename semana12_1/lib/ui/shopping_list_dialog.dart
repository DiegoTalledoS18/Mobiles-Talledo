import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:semana12_1/models/shopping_list.dart';
import 'package:semana12_1/util/dbhelper.dart';

class ShoppingListDialog{
  final txtName = TextEditingController ();
  final txtPriority = TextEditingController();
  Widget buildDialog (BuildContext context, ShoppingList list, bool isNew) {
    DbHelper helper = DbHelper();
    if (!isNew) {
      txtName.text = list.name;
      txtPriority.text = list.priority.toString();
    }
    return AlertDialog(
        title: Text((isNew)? 'Nuevo elemento' : 'Edición del elemento'),
        shape: RoundedRectangleBorder (
            borderRadius: BorderRadius.circular (25)
        ), // RoundedRectangleBorder
      content: SingleChildScrollView(
        child: Column(
          children: <Widget>[
          TextField(
            controller: txtName,
            decoration: InputDecoration (
              hintText: 'Nombre'
            ), // InputDecoration
          ),
            TextField(
              controller: txtPriority,
              keyboardType: TextInputType.number,
              decoration: InputDecoration(
                hintText: 'Priority(1..3)'
              ),
            ),
            ElevatedButton(
              child: Text ('Grabar'),
              onPressed: (){
              list. name = txtName. text;
              list.priority = int.parse(txtPriority.text);
              helper.insertList(list);
              Navigator.pop(context);
              }, )
          ],
        ),
      ),
    );
// AlertDialog
  }
}