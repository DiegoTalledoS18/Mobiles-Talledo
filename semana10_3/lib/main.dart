import 'package:flutter/material.dart';
import 'package:english_words/english_words.dart';

void main() {
  runApp( WordGenerator());
}
class WordGenerator extends StatelessWidget {
  final wordPair=WordPair.random();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Words"),
        backgroundColor: Colors.blue,
      ),
      body: Center(
        child: Text(wordPair.asCamelCase)),
      );
  }
}

