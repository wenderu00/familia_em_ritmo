import 'package:familia_em_ritmo/models/splash_screen.dart';
import 'package:flutter/material.dart';

void main() => runApp(FamiliaEmRitmoApp());

class FamiliaEmRitmoApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Família em Ritmo',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        primarySwatch: Colors.blue,
        scaffoldBackgroundColor: Colors.white,
      ),
      home: SplashScreen(), // <- começa pela splash
    );
  }
}
