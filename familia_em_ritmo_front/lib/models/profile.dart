import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'change_password.dart'; // Certifique-se de que o caminho está correto

class ProfileContent extends StatefulWidget {
  const ProfileContent({Key? key}) : super(key: key);

  @override
  State<ProfileContent> createState() => _ProfileContentState();
}

class _ProfileContentState extends State<ProfileContent> {
  final _formKeyProfile = GlobalKey<FormState>();
  bool isEditingProfile = false;

  String nome = '';
  String email = ''; // não usado no back-end ainda
  String telefone = ''; // idem

  late TextEditingController nomeController;
  late TextEditingController emailController;
  late TextEditingController telefoneController;

  @override
  void initState() {
    super.initState();
    nomeController = TextEditingController();
    emailController = TextEditingController();
    telefoneController = TextEditingController();

    fetchRelativeById(1); // Exemplo com ID fixo
  }

  Future<void> fetchRelativeById(int id) async {
    try {
      final response = await http.get(
        Uri.parse('http://localhost:8080/relative/by_id?id=$id'),
      );

      if (response.statusCode == 200) {
        final data = json.decode(response.body);
        setState(() {
          nome = data['name'];
          nomeController.text = nome;
        });
      } else {
        throw Exception('Erro ao buscar dados');
      }
    } catch (e) {
      print('Erro na requisição: $e');
    }
  }

  Future<void> createRelative(String name) async {
    try {
      final response = await http.post(
        Uri.parse('http://localhost/relative'),
        headers: {'Content-Type': 'application/json'},
        body: jsonEncode({'name': name}),
      );

      if (response.statusCode == 200) {
        ScaffoldMessenger.of(context).showSnackBar(
          const SnackBar(content: Text('Dados salvos com sucesso!')),
        );
      } else {
        throw Exception('Erro ao salvar dados');
      }
    } catch (e) {
      print('Erro ao criar familiar: $e');
    }
  }

  @override
  void dispose() {
    nomeController.dispose();
    emailController.dispose();
    telefoneController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final height = MediaQuery.of(context).size.height;
    return Container(
      color: const Color.fromARGB(0, 245, 245, 245),
      height: height,
      child: SingleChildScrollView(
        padding: const EdgeInsets.all(16),
        child: ConstrainedBox(
          constraints: BoxConstraints(minHeight: height - 32),
          child: Center(
            child: Form(
              key: _formKeyProfile,
              child: Column(
                mainAxisSize: MainAxisSize.min,
                children: [
                  _buildInputCard(
                    icon: Icons.person,
                    label: 'Nome',
                    controller: nomeController,
                    enabled: isEditingProfile,
                  ),
                  _buildInputCard(
                    icon: Icons.email,
                    label: 'Email',
                    controller: emailController,
                    enabled: isEditingProfile,
                  ),
                  _buildInputCard(
                    icon: Icons.phone,
                    label: 'Telefone',
                    controller: telefoneController,
                    enabled: isEditingProfile,
                  ),
                  const SizedBox(height: 20),
                  isEditingProfile
                      ? ElevatedButton(
                          style: ElevatedButton.styleFrom(
                            backgroundColor: const Color(0xFF1155A3),
                            foregroundColor: Colors.white,
                            padding: const EdgeInsets.symmetric(
                                vertical: 14, horizontal: 24),
                            shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(12),
                            ),
                            elevation: 4,
                          ),
                          onPressed: () {
                            if (_formKeyProfile.currentState!.validate()) {
                              setState(() {
                                isEditingProfile = false;
                              });
                              createRelative(nomeController.text);
                            }
                          },
                          child: const Text('Salvar alterações'),
                        )
                      : OutlinedButton(
                          style: OutlinedButton.styleFrom(
                            backgroundColor:
                                const Color.fromARGB(255, 255, 255, 255),
                            foregroundColor: const Color(0xFF1155A3),
                            side: const BorderSide(
                                color: Color(0xFF1155A3), width: 2),
                            padding: const EdgeInsets.symmetric(
                                vertical: 14, horizontal: 24),
                            shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(12),
                            ),
                          ),
                          onPressed: () {
                            setState(() {
                              isEditingProfile = true;
                            });
                          },
                          child: const Text('Editar Perfil'),
                        ),
                  const SizedBox(height: 10),
                  OutlinedButton(
                    style: OutlinedButton.styleFrom(
                      backgroundColor: const Color.fromARGB(255, 255, 255, 255),
                      foregroundColor: const Color(0xFF1155A3),
                      side:
                          const BorderSide(color: Color(0xFF1155A3), width: 2),
                      padding: const EdgeInsets.symmetric(
                          vertical: 14, horizontal: 24),
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(12),
                      ),
                    ),
                    onPressed: () {
                      Navigator.of(context).push(
                        MaterialPageRoute(
                          builder: (_) => const ChangePasswordView(),
                        ),
                      );
                    },
                    child: const Text('Alterar Senha'),
                  ),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }

  Widget _buildInputCard({
    required IconData icon,
    required String label,
    required TextEditingController controller,
    bool enabled = true,
  }) {
    return Container(
      margin: const EdgeInsets.symmetric(vertical: 8),
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
        leading: Icon(icon, color: const Color(0xFF1155A3)),
        title: TextFormField(
          controller: controller,
          enabled: enabled,
          decoration: InputDecoration(
            hintText: label,
            border: InputBorder.none,
          ),
          style: const TextStyle(fontWeight: FontWeight.w500),
          validator: (value) {
            if (value == null || value.trim().isEmpty) {
              return 'Preencha o campo $label';
            }
            return null;
          },
        ),
      ),
    );
  }
}
