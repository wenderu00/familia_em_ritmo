import 'package:flutter/material.dart';
import 'kids.dart';
import 'routine.dart';
import 'profile.dart';

class LayoteScreen extends StatefulWidget {
  const LayoteScreen({Key? key}) : super(key: key);

  @override
  _LayoteScreenState createState() => _LayoteScreenState();
}

class _LayoteScreenState extends State<LayoteScreen> {
  int _currentIndex = 0;

  final List<String> _titles = [
    'Família em Ritmo',
    'Família em Ritmo',
    'Família em Ritmo',
  ];

  final List<Widget> _pages = [
    KidsContent(),
    RoutineContent(),
    ProfileContent(),
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: PreferredSize(
        preferredSize: const Size.fromHeight(kToolbarHeight + 4),
        child: Column(
          children: [
            AppBar(
              title: Text(_titles[_currentIndex]),
              centerTitle: true,
              backgroundColor: const Color.fromARGB(21, 255, 216, 59),
            ),
            Container(
              height: 4,
              color: const Color(0xFF1155A3),
            ),
          ],
        ),
      ),
      body: Stack(
        children: [
          Positioned.fill(
            child: Image.asset(
              'assets/Background.png',
              fit: BoxFit.cover,
            ),
          ),
          Padding(
            padding: const EdgeInsets.all(16.0),
            child: _pages[_currentIndex],
          ),
        ],
      ),
      bottomNavigationBar: Column(
        mainAxisSize: MainAxisSize.min,
        children: [
          Container(
            height: 4,
            color: const Color(0xFF1155A3),
          ),
          BottomNavigationBar(
            currentIndex: _currentIndex,
            iconSize: 50,
            onTap: (index) {
              setState(() {
                _currentIndex = index;
              });
            },
            selectedItemColor: const Color(0xFF1155A3),
            unselectedItemColor: Colors.grey,
            items: [
              BottomNavigationBarItem(
                icon: CircleAvatar(
                  backgroundColor: Colors.transparent,
                  radius: 16,
                  child: Image.asset('assets/sinoF.png', width: 50, height: 50),
                ),
                label: 'Crianças',
              ),
              BottomNavigationBarItem(
                icon: CircleAvatar(
                  backgroundColor: Colors.transparent,
                  radius: 16,
                  child:
                      Image.asset('assets/RelogioF.png', width: 50, height: 50),
                ),
                label: 'Rotinas',
              ),
              BottomNavigationBarItem(
                icon: CircleAvatar(
                  backgroundColor: Colors.transparent,
                  radius: 16,
                  child:
                      Image.asset('assets/profileF.png', width: 50, height: 50),
                ),
                label: 'Perfil',
              ),
            ],
          ),
        ],
      ),
    );
  }
}
