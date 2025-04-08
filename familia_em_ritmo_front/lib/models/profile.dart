import 'package:flutter/material.dart';

class ProfileContent extends StatelessWidget {
  final List<Map<String, String>> kids = [
    {'title': 'Criança 1', 'subtitle': 'Nascimento: 01/01/2020'},
    {'title': 'Criança 2', 'subtitle': 'Nascimento: 02/02/2021'},
  ];

  ProfileContent({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
      itemCount: kids.length,
      itemBuilder: (context, index) {
        final item = kids[index];
        return Container(
          margin: const EdgeInsets.symmetric(vertical: 8, horizontal: 4),
          decoration: BoxDecoration(
            color: Colors.white,
            border: Border.all(color: const Color(0xFF1155A3), width: 2),
            borderRadius: BorderRadius.circular(12),
            boxShadow: const [
              BoxShadow(
                color: Colors.black12,
                blurRadius: 4,
                offset: Offset(2, 2),
              ),
            ],
          ),
          child: ListTile(
            leading: const Icon(Icons.child_care, color: Color(0xFF1155A3)),
            title: Text(
              item['title'] ?? '',
              textAlign: TextAlign.center,
            ),
            subtitle: Text(
              item['subtitle'] ?? '',
              textAlign: TextAlign.center,
            ),
            trailing: const Icon(Icons.arrow_forward_ios, size: 16),
          ),
        );
      },
    );
  }
}
