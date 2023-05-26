import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(primarySwatch: Colors.indigo),
      home: LoginPage(),
    );
  }
}

class LoginPage extends StatefulWidget {
  const LoginPage({Key? key}) : super(key: key);

  @override
  State<LoginPage> createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.black,
      body: Stack(
        fit: StackFit.expand,
        children: <Widget> [
          Image(
            image: AssetImage("lib/assets/vader.png"),
            fit: BoxFit.cover,
            color: Colors.white,
            colorBlendMode: BlendMode.darken,
          ),
          Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              FlutterLogo(
                size: 100.0,
              ),
              Form(
                  child: Theme(
                    data:ThemeData(
                    brightness: Brightness.dark,primarySwatch: Colors.red,
                      inputDecorationTheme: InputDecorationTheme(
                        labelStyle: TextStyle(
                          color: Colors.white,
                          fontSize: 20
                        )
                      ),
                    ),
                    child: Container(
                      padding: EdgeInsets.all(35),
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.center,
                        children: <Widget>[
                          TextFormField(
                            decoration: InputDecoration(
                              labelText: "Enter e-mail"
                            ),
                            keyboardType: TextInputType.emailAddress,
                          ),
                          TextFormField(
                            decoration: InputDecoration(
                                labelText: "Enter password"
                            ),
                            keyboardType: TextInputType.text,
                            obscureText: true,
                          ),
                          Padding(
                            padding: const EdgeInsets.only(top: 30),
                            child: MaterialButton(
                              height: 60,
                              minWidth: 60,
                              splashColor: Colors.black,
                                color: Colors.red,
                                textColor: Colors.white,
                                child: Icon(FontAwesomeIcons.rightToBracket),
                                onPressed: (){

                                }),
                          )
                        ],
                      ),
                    ),
                  )
              )
            ],
          )
        ],
      ),
    );
  }
}
