import 'package:flutter/material.dart';
import 'change_password.dart'; // Certifique-se de que o caminho está correto

class ProfileContent extends StatefulWidget {
  const ProfileContent({Key? key}) : super(key: key);

  @override
  State<ProfileContent> createState() => _ProfileContentState();
}

class _ProfileContentState extends State<ProfileContent> {
  final _formKeyProfile = GlobalKey<FormState>();

  // Flag para controle da edição de perfil
  bool isEditingProfile = false;

  // Dados do perfil
  String nome = '';
  String email = '';
  String telefone = '';

  // Controllers do perfil
  late TextEditingController nomeController;
  late TextEditingController emailController;
  late TextEditingController telefoneController;

  @override
  void initState() {
    super.initState();
    nomeController = TextEditingController(text: nome);
    emailController = TextEditingController(text: email);
    telefoneController = TextEditingController(text: telefone);
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
                  // Botão de salvar ou editar perfil
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
                                nome = nomeController.text;
                                email = emailController.text;
                                telefone = telefoneController.text;
                                isEditingProfile = false;
                              });
                              ScaffoldMessenger.of(context).showSnackBar(
                                const SnackBar(
                                    content: Text('Cadastro atualizado!')),
                              );
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
                  // Botão para ir à tela de alterar senha
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
                      // Navega para a tela de alterar senha
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

  /// Widget reutilizável para campos de entrada do perfil
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
