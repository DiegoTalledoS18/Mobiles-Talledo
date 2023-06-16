import 'package:app_sem12_s1/ui/item_list_dialog.dart';
import 'package:flutter/material.dart';
import 'package:app_sem12_s1/util/dbhelper.dart';
import 'package:app_sem12_s1/models/shopping_list.dart';
import 'package:app_sem12_s1/models/item_list.dart';

class ItemScreen extends StatefulWidget {
  final ShoppingList shoppingList;
  ItemScreen(this.shoppingList);
  @override
  State<ItemScreen> createState() => _ItemScreenState(this.shoppingList);
}



class _ItemScreenState extends State<ItemScreen> {
  final ShoppingList shoppingList;
  _ItemScreenState(this.shoppingList);

  DbHelper? helper;
  List<ListItem> items=[];

  @override

  Widget build(BuildContext context) {
    helper=DbHelper();
    showData(this.shoppingList.id);

    ItemListDialog dialog =ItemListDialog();

    return Scaffold(
      appBar: AppBar(
        title: Text(shoppingList.name),
      ),
        body: ListView.builder(itemCount: (items!=null ? items.length:0),
            itemBuilder: (BuildContext context, int index){
          return ListTile(
            title: Text(items[index].name),
            subtitle: Text('Cantidad: ${items[index].quatity} - observacion: ${items[index].note}'),
            trailing: IconButton(
              icon: Icon(Icons.edit),
              onPressed: (){
                showDialog(
                  context: context,
                  builder: (BuildContext context)=>
                      dialog.buildDialog(context, items[index], false));
              },
            ),
          );
        })

    );

  }

  Future showData(int idList) async{
    await helper!.openDB();
    items=await helper!.getItems(idList);

    setState(() {
      items=items;
    });
  }

}