import 'package:flutter/material.dart';

void main() {
  runApp( MyStatefullApp());
}

//Primero hacemos el stateless, escribimos st
/*
class MyStatelessApp extends StatelessWidget {
  int counter=0;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text("Ejemplo de widget Sin estado"),
        ),
        body: Center(
          child: Text(counter.toString(),
          style: TextStyle(fontSize: 50),),
        ),
        floatingActionButton: FloatingActionButton(
          child: Icon(Icons.plus_one_sharp),
          onPressed: (){
            counter++;
            print(counter);
          },
        ),
      ),
    );
  }
}*/
class MyStatefullApp extends StatefulWidget {

  @override
  State<MyStatefullApp> createState() => _MyStatefullAppState();
}

class _MyStatefullAppState extends State<MyStatefullApp> {
  int counter=0;
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text("Ejemplo de widget Con estado"),
        ),
        body: Center(
          child: Text(counter.toString(),
            style: TextStyle(fontSize: 50),),
        ),
        floatingActionButton: FloatingActionButton(
          child: Icon(Icons.plus_one_sharp),
          onPressed: (){
            counter++;
            print(counter);
            setState(() {
            });
          },
        ),
      ),
    );
  }
}




