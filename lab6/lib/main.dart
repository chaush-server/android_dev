import 'package:flutter/material.dart';
import 'dart:math';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.red,
      ),
      home: const MyHomePage(title: 'Угадайте число!'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  final String title;

  const MyHomePage({Key? key, required this.title}) : super(key: key);

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  final _random = Random();
  late int _randomNumber;

  static const String _numberGt = 'Введённое число больше заданного';
  static const String _numberLt = 'Введённое число меньше заданного';
  static const String _numberEq = 'Угадал!';
  static const String _inputNumber = 'Попробуй угадать число от 1 до 100)';
  static const String _submit = 'Ввести значение';

  @override
  void initState() {
    super.initState();
    _randomNumber = _random.nextInt(100);
  }

  String _textView = _inputNumber;

  void _checkNumber(int number) {
    // print(_randomNumber);
    setState(() {
      if (number > _randomNumber) {
        _textView = _numberGt;
      } else if (number < _randomNumber) {
        _textView = _numberLt;
      } else {
        _textView = _numberEq;

        _randomNumber = _random.nextInt(100);
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    final TextEditingController controller = TextEditingController();
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Column(
        // mainAxisAlignment: MainAxisAlignment.center,
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text(_textView),
          TextField(
            controller: controller,
          ),
          SizedBox(
            width: double.infinity,
            child: ElevatedButton(
              onPressed: () {
                if (controller.text.isNotEmpty) {
                  _checkNumber(int.parse(controller.text));
                }
              },
              child: const Text(_submit),
            ),
          ),
        ],
      ),
    );
  }
}
