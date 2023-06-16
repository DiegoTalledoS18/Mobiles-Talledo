import 'package:app_sem12_s1/models/item_list.dart';
import 'package:flutter/material.dart';
import 'package:app_sem12_s1/util/dbhelper.dart';
import 'package:app_sem12_s1/models/shopping_list.dart';

class ItemListDialog{
  final txtName = TextEditingController();
  final txtQuantity = TextEditingController();
  final txtNote = TextEditingController();

  Widget buildDialog(BuildContext context, ListItem item, bool isNew){
    DbHelper helper = DbHelper();
    if (!isNew) {
      txtName.text = item.name;
      txtQuantity.text = item.quatity;
      txtNote.text = item.note;
    }
    else{
      txtName.text = "";
      txtQuantity.text = "";
      txtNote.text = "";
    }

    return AlertDialog(
      title: Text((isNew)? "New shoppinglist" : "Edit shoppinglist"),
      content: SingleChildScrollView(
        child: Column(
          children: <Widget>[
            TextField(
              controller: txtName,
              decoration: InputDecoration(
                  hintText: "Ingrese nombre"
              ),
            ),
            TextField(
              controller: txtQuantity,
              decoration: InputDecoration(
                  hintText: "Ingrese cantidad"
              ),
            ),
            TextField(
              controller: txtNote,
              decoration: InputDecoration(
                  hintText: "Ingrese detalles"
              ),
            ),
            ElevatedButton(
              child: Text("Grabar"),
              onPressed: (){
                item.name = txtName.text;
                item.quatity = txtQuantity.text;
                item.note = txtNote.text;
                helper.insertItems(item);
                Navigator.pop(context);
              }, )
          ],
        ),
      ),
    );
  }
}