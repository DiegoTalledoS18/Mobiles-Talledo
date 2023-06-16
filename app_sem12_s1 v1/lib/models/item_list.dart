class ListItem{
  int id;
  int idList;

  String name;

  String quatity;
  String note;

  ListItem(this.id,this.idList,this.name, this.quatity, this.note);

  Map<String, dynamic> toMap(){
    return {
      'id': (id==0)? null:id,
      'idList': idList,
      'name': name,
      'quantity': quatity,
      'note' : note,
    };
  }
}