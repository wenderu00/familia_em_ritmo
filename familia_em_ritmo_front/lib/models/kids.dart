import 'package:flutter/material.dart';
import 'package:intl/intl.dart';

class Kid {
  final String name;
  final DateTime birthdate;

  Kid({required this.name, required this.birthdate});

  int get age {
    final now = DateTime.now();
    int age = now.year - birthdate.year;
    if (now.month < birthdate.month ||
        (now.month == birthdate.month && now.day < birthdate.day)) {
      age--;
    }
    return age;
  }
}

class KidsContent extends StatefulWidget {
  @override
  _KidsContentState createState() => _KidsContentState();
}

class _KidsContentState extends State<KidsContent> {
  final List<Kid> kids = [];

  void _addKid(String name, DateTime birthdate) {
    setState(() {
      kids.add(Kid(name: name, birthdate: birthdate));
    });
  }

  void _editKid(int index, String name, DateTime birthdate) {
    setState(() {
      kids[index] = Kid(name: name, birthdate: birthdate);
    });
  }

  void _deleteKid(int index) {
    setState(() {
      kids.removeAt(index);
    });
  }

  void _showAddEditKidDialog(BuildContext context, {int? index}) {
    final TextEditingController nameController = TextEditingController();
    DateTime? selectedDate;

    if (index != null) {
      nameController.text = kids[index].name;
      selectedDate = kids[index].birthdate;
    }

    showDialog(
      context: context,
      builder: (context) {
        return StatefulBuilder(
          builder: (context, setStateDialog) {
            return AlertDialog(
              title:
                  Text(index == null ? 'Adicionar Criança' : 'Editar Criança'),
              content: Column(
                mainAxisSize: MainAxisSize.min,
                children: [
                  TextField(
                    controller: nameController,
                    decoration: const InputDecoration(
                      labelText: 'Nome',
                      border: OutlineInputBorder(),
                    ),
                  ),
                  const SizedBox(height: 20),
                  Row(
                    children: [
                      Text(selectedDate == null
                          ? 'Selecione a data de nascimento'
                          : 'Data: ${DateFormat('dd/MM/yyyy').format(selectedDate!)}'),
                      IconButton(
                        icon: const Icon(Icons.calendar_today),
                        onPressed: () async {
                          final date = await showDatePicker(
                            context: context,
                            initialDate: selectedDate ?? DateTime.now(),
                            firstDate: DateTime(1900),
                            lastDate: DateTime.now(),
                          );
                          if (date != null) {
                            setStateDialog(() => selectedDate = date);
                          }
                        },
                      ),
                    ],
                  ),
                ],
              ),
              actions: [
                TextButton(
                  onPressed: () => Navigator.pop(context),
                  child: const Text('Cancelar'),
                ),
                TextButton(
                  onPressed: () {
                    if (nameController.text.isNotEmpty &&
                        selectedDate != null) {
                      if (index == null) {
                        _addKid(nameController.text, selectedDate!);
                      } else {
                        _editKid(index, nameController.text, selectedDate!);
                      }
                      Navigator.pop(context);
                    }
                  },
                  child: const Text('Salvar'),
                ),
              ],
            );
          },
        );
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor:
          Colors.transparent, // Se estiver usando um background customizado
      floatingActionButton: FloatingActionButton(
        onPressed: () => _showAddEditKidDialog(context),
        child: Image.asset(
          'assets/Adicionar.png',
          width: 100,
          height: 100,
        ),
      ),
      body: Container(
        decoration: const BoxDecoration(
          image: DecorationImage(
            image: AssetImage('assets/background.png'),
            fit: BoxFit.cover,
          ),
        ),
        child: kids.isEmpty
            ? const Center(
                child: Text(
                  '',
                  textAlign: TextAlign.center,
                  style: TextStyle(
                    fontSize: 18,
                    color: Colors.black87,
                    fontWeight: FontWeight.bold,
                  ),
                ),
              )
            : ListView.builder(
                itemCount: kids.length,
                itemBuilder: (context, index) {
                  final kid = kids[index];
                  return Container(
                    margin:
                        const EdgeInsets.symmetric(vertical: 8, horizontal: 4),
                    decoration: BoxDecoration(
                      color: Colors.white,
                      border:
                          Border.all(color: const Color(0xFF1155A3), width: 2),
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
                      leading: Image.asset(
                        'assets/star.png',
                        width: 40,
                        height: 40,
                      ),
                      title: Text(
                        kid.name,
                        textAlign: TextAlign.center,
                        style: const TextStyle(fontWeight: FontWeight.bold),
                      ),
                      subtitle: Text(
                        'Nascimento: ${DateFormat('dd/MM/yyyy').format(kid.birthdate)}\nIdade: ${kid.age} anos',
                        textAlign: TextAlign.center,
                      ),
                      trailing: Row(
                        mainAxisSize: MainAxisSize.min,
                        children: [
                          IconButton(
                            icon: Image.asset(
                              'assets/Edit.png',
                              width: 24,
                              height: 24,
                            ),
                            onPressed: () =>
                                _showAddEditKidDialog(context, index: index),
                          ),
                          IconButton(
                            icon: Image.asset(
                              'assets/lixeira.png',
                              width: 24,
                              height: 24,
                            ),
                            onPressed: () => _deleteKid(index),
                          ),
                        ],
                      ),
                    ),
                  );
                },
              ),
      ),
    );
  }
}
