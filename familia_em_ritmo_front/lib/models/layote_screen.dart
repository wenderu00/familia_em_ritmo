import 'package:flutter/material.dart';

class LayoteScreen extends StatelessWidget {
  final String title;
  final Widget body;
  final VoidCallback onAddPressed;

  const LayoteScreen({
    required this.title,
    required this.body,
    required this.onAddPressed,
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text(title)),
      body: Stack(
        children: [
          // Imagem de fundo
          Positioned.fill(
            child: Image.asset(
              'assets/Background.png',
              fit: BoxFit.cover,
            ),
          ),
          // Conteúdo com padding
          Padding(
            padding: const EdgeInsets.all(16.0),
            child: body,
          ),
        ],
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: onAddPressed,
        child: Icon(Icons.add),
      ),
    );
  }
}
