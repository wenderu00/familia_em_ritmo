import 'package:flutter/material.dart';
import 'models/kids.dart';
import 'models/agenda.dart';
import 'models/routine.dart';

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
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: HomeNavigation(),
    );
  }
}

class HomeNavigation extends StatefulWidget {
  @override
  _HomeNavigationState createState() => _HomeNavigationState();
}

class _HomeNavigationState extends State<HomeNavigation> {
  int _currentIndex = 0;

  final List<Widget> _screens = [
    KidsScreen(),
    RoutineScreen(),
    AgendaScreen(),
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: _screens[_currentIndex],
      bottomNavigationBar: Container(
        decoration: BoxDecoration(
          border: Border(
            top: BorderSide(
              color: Color(0xFF1155A3), // contorno azul
              width: 2,
            ),
          ),
        ),
        child: BottomNavigationBar(
          currentIndex: _currentIndex,
          onTap: (index) => setState(() => _currentIndex = index),
          selectedItemColor: Color(0xFF1155A3),
          unselectedItemColor: Colors.grey,
          items: [
            BottomNavigationBarItem(
              icon: CircleAvatar(
                backgroundColor: Colors.transparent,
                radius: 16,
                child: Image.asset('assets/sinoF.png', width: 24, height: 24),
              ),
              label: 'Crianças',
            ),
            BottomNavigationBarItem(
              icon: CircleAvatar(
                backgroundColor: Colors.transparent,
                radius: 16,
                child:
                    Image.asset('assets/RelogioF.png', width: 24, height: 24),
              ),
              label: 'Rotinas',
            ),
            BottomNavigationBarItem(
              icon: CircleAvatar(
                backgroundColor: Colors.transparent,
                radius: 16,
                child: Image.asset('assets/CalendarioF.png',
                    width: 24, height: 24),
              ),
              label: 'Agenda',
            ),
          ],
        ),
      ),
    );
  }
}
