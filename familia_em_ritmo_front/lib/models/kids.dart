import 'package:familia_em_ritmo/models/layote_screen.dart';
import 'package:flutter/material.dart';
import 'layote_screen.dart';

class KidsScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return LayoteScreen(
      title: 'Crianças',
      body: ListView.builder(
        itemCount: 3, // Placeholder
        itemBuilder: (context, index) {
          return Container(
            margin: const EdgeInsets.symmetric(vertical: 8, horizontal: 4),
            decoration: BoxDecoration(
              color: Colors.white,
              border: Border.all(
                color: Color(0xFF1155A3), // contorno azul
                width: 2,
              ),
              borderRadius: BorderRadius.circular(12),
              boxShadow: [
                BoxShadow(
                  color: Colors.black12,
                  blurRadius: 4,
                  offset: Offset(2, 2),
                ),
              ],
            ),
            child: ListTile(
              leading: Icon(Icons.child_care, color: Color(0xFF1155A3)),
              title: Text('Criança ${index + 1}'),
              subtitle: Text('Nascimento: 01/01/2020'),
              trailing: Icon(Icons.arrow_forward_ios, size: 16),
            ),
          );
        },
      ),
      onAddPressed: () {
        // TODO: Adicionar nova criança
      },
    );
  }
}
