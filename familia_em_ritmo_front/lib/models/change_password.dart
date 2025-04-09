import 'package:flutter/material.dart';

class ChangePasswordView extends StatefulWidget {
  const ChangePasswordView({Key? key}) : super(key: key);

  @override
  State<ChangePasswordView> createState() => _ChangePasswordViewState();
}

class _ChangePasswordViewState extends State<ChangePasswordView> {
  final _formKeyPassword = GlobalKey<FormState>();

  // Controllers de senha
  late TextEditingController senhaAtualController;
  late TextEditingController novaSenhaController;
  late TextEditingController confirmarSenhaController;

  // Controle de visibilidade dos campos de senha
  bool senhaAtualVisivel = false;
  bool novaSenhaVisivel = false;
  bool confirmarSenhaVisivel = false;

  @override
  void initState() {
    super.initState();
    senhaAtualController = TextEditingController();
    novaSenhaController = TextEditingController();
    confirmarSenhaController = TextEditingController();
  }

  @override
  void dispose() {
    senhaAtualController.dispose();
    novaSenhaController.dispose();
    confirmarSenhaController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final height = MediaQuery.of(context).size.height;
    return Scaffold(
      appBar: AppBar(
        backgroundColor: const Color(0xFF1155A3),
        leading: IconButton(
          icon: const Icon(Icons.arrow_back),
          onPressed: () {
            // Volta à tela anterior (Perfil)
            Navigator.of(context).pop();
          },
        ),
        title: const Text('Alterar Senha'),
      ),
      body: Container(
        color: const Color(0xFFF5F5F5),
        height: height,
        child: SingleChildScrollView(
          padding: const EdgeInsets.all(16),
          child: ConstrainedBox(
            constraints:
                BoxConstraints(minHeight: height - kToolbarHeight - 32),
            child: Center(
              child: Form(
                key: _formKeyPassword,
                child: Column(
                  mainAxisSize: MainAxisSize.min,
                  children: [
                    _buildPasswordCard(
                      icon: Icons.lock_outline,
                      label: 'Senha atual',
                      controller: senhaAtualController,
                      obscureText: !senhaAtualVisivel,
                      onToggleVisibility: () {
                        setState(() {
                          senhaAtualVisivel = !senhaAtualVisivel;
                        });
                      },
                    ),
                    _buildPasswordCard(
                      icon: Icons.lock,
                      label: 'Nova senha',
                      controller: novaSenhaController,
                      obscureText: !novaSenhaVisivel,
                      onToggleVisibility: () {
                        setState(() {
                          novaSenhaVisivel = !novaSenhaVisivel;
                        });
                      },
                    ),
                    _buildPasswordCard(
                      icon: Icons.lock,
                      label: 'Confirmar nova senha',
                      controller: confirmarSenhaController,
                      obscureText: !confirmarSenhaVisivel,
                      onToggleVisibility: () {
                        setState(() {
                          confirmarSenhaVisivel = !confirmarSenhaVisivel;
                        });
                      },
                    ),
                    const SizedBox(height: 20),
                    ElevatedButton(
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
                        if (_formKeyPassword.currentState!.validate()) {
                          if (novaSenhaController.text !=
                              confirmarSenhaController.text) {
                            ScaffoldMessenger.of(context).showSnackBar(
                              const SnackBar(
                                  content: Text('As senhas não coincidem!')),
                            );
                            return;
                          }
                          // Aqui você pode inserir a lógica de alteração efetiva da senha.
                          ScaffoldMessenger.of(context).showSnackBar(
                            const SnackBar(
                                content: Text('Senha alterada com sucesso!')),
                          );
                          Navigator.of(context).pop();
                        }
                      },
                      child: const Text('Salvar nova senha'),
                    ),
                  ],
                ),
              ),
            ),
          ),
        ),
      ),
    );
  }

  /// Widget reutilizável para os campos de senha com ícone de mostrar/ocultar
  Widget _buildPasswordCard({
    required IconData icon,
    required String label,
    required TextEditingController controller,
    required bool obscureText,
    required VoidCallback onToggleVisibility,
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
          obscureText: obscureText,
          decoration: InputDecoration(
            hintText: label,
            border: InputBorder.none,
            suffixIcon: IconButton(
              icon: Icon(
                obscureText ? Icons.visibility_off : Icons.visibility,
                color: const Color(0xFF1155A3),
              ),
              onPressed: onToggleVisibility,
            ),
          ),
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
