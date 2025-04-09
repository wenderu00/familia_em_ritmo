import 'package:flutter/material.dart';

class RoutineContent extends StatefulWidget {
  const RoutineContent({Key? key}) : super(key: key);

  @override
  State<RoutineContent> createState() => _RoutineContentState();
}

class _RoutineContentState extends State<RoutineContent> {
  DateTime selectedDate = DateTime.now();
  final Map<String, List<String>> routineMap = {
    '2025-04-09': [
      '1:00 PM – 1:30 PM',
      '1:15 PM – 1:45 PM',
    ],
    '2025-04-10': [
      '2:00 PM – 2:30 PM',
    ],
  };

  List<String> getTimeSlotsForDate(DateTime date) {
    final key =
        "${date.year}-${date.month.toString().padLeft(2, '0')}-${date.day.toString().padLeft(2, '0')}";
    return routineMap[key] ?? [];
  }

  @override
  Widget build(BuildContext context) {
    final slots = getTimeSlotsForDate(selectedDate);

    return Scaffold(
      backgroundColor: const Color.fromARGB(255, 255, 255, 255),
      body: SingleChildScrollView(
        child: Column(
          children: [
            CalendarDatePicker(
              initialDate: selectedDate,
              firstDate: DateTime(2020),
              lastDate: DateTime(2030),
              onDateChanged: (date) {
                setState(() {
                  selectedDate = date;
                });
              },
            ),
            const SizedBox(height: 8),
            if (slots.isEmpty)
              const Padding(
                padding: EdgeInsets.all(16.0),
                child: Text(
                  "Nenhuma rotina para esta data.",
                  style: TextStyle(fontSize: 16, color: Colors.black54),
                ),
              )
            else
              Column(
                children: slots.map((slot) {
                  return Padding(
                    padding:
                        const EdgeInsets.symmetric(horizontal: 16, vertical: 4),
                    child: Container(
                      width: double.infinity,
                      padding: const EdgeInsets.symmetric(vertical: 16),
                      decoration: BoxDecoration(
                        color: const Color.fromRGBO(255, 255, 255, 1),
                        borderRadius: BorderRadius.circular(8),
                        border: Border.all(color: Colors.black87),
                      ),
                      child: Text(
                        slot,
                        textAlign: TextAlign.center,
                        style: const TextStyle(fontSize: 16),
                      ),
                    ),
                  );
                }).toList(),
              ),
            const SizedBox(height: 20),
          ],
        ),
      ),
    );
  }
}
