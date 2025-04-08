import 'package:familia_em_ritmo/models/layote_screen.dart';
import 'package:flutter/material.dart';
import 'layote_screen.dart';

class RoutineScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return LayoteScreen(
      title: 'Rotinas',
      body: ListView.builder(
        itemCount: 3, // Placeholder
        itemBuilder: (context, index) {
          return Card(
            child: ListTile(
              leading: Icon(Icons.schedule),
              title: Text('Rotina ${index + 1}'),
              subtitle: Text('Horário: 08:00'),
            ),
          );
        },
      ),
      onAddPressed: () {},
    );
  }
}
