
//今日紹介したものは一通り実装してください。
//
//文字列のリストを作ってください。要素数は10個。
//その文字列に対して、文字数が2以上のものを抽出して、文字列に変換をしてください。区切り文字はカンマ（,）で行ってください。
//その文字列を出力してください。
//
//数値のリストを作ってください。要素数は10個。
//その数値の中の奇数のものだけを抽出して、平均値を出してください。
//その平均値を出力してください。
//
//ChatGPTなどの生成AIを使って、Stream APIの基礎的な課題を一つ作ってもらってください。
//それを実際に実践してみてください。

package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

//    以下、講義内容
//    List<Integer> numberList = List.of(1,2,3,4,5,6,7,8,9,10);
//    numberList.stream()
//        .filter(number -> number <= 5)
//        .forEach(System.out::println);
//
//    numberList.stream()
//        .limit(3)
//        .forEach(System.out::println);
//
//    List<String> studentList = List.of("inoue", "enami", "tanaka", "enami");
//    studentList.stream()
//        .map(String::toUpperCase)
//        .forEach(System.out::println);
//
//    studentList.stream()
//        .sorted()
//        .forEach(System.out::println);
//
//    System.out.println(studentList.stream()
//        .map(String::toUpperCase)
//        .sorted()
//        .distinct()
//        .allMatch(v -> v.startsWith("E"))
//    );

//    ここから課題
//    ①プログラミング言語リストを定義して、②文字以上のものを表示する。
        List<String> languageList = List.of("C", "C++", "Java", "C#", "Python", "R", "Ruby", "PHP", "JavaScript", "D");
        System.out.println(languageList.stream()
            .filter(v -> v.length() >= 2)
            .collect(Collectors.joining(",")));

//    ②ランダムの整数リストを定義して、奇数のものを表示する。
        List<Integer> randomNumberList = List.of(543, 7, 1523, 765, 7534, 234, 876, 73, 673, 3456, 78, 124);
        System.out.println(randomNumberList.stream()
            .filter(v -> v % 2 == 1)
            .collect(Collectors.averagingDouble(v -> v)));

//    ChatGPTによる課題
//    課題: 学生データのフィルタリングと集計
//        シナリオ
//    あなたは学校のデータ管理システムを担当しています。学生のリストから特定の条件に合った学生を抽出し、その情報を元にいくつかの集計を行う必要があります。

//    学生クラス
//    まず、Studentクラスを定義します。(Student.java)

//    データリスト
//    次に、いくつかのStudentオブジェクトのリストを用意します。
        List<Student> students = Arrays.asList(
            new Student("Alice", 20, 85.5),
            new Student("Bob", 22, 70.0),
            new Student("Charlie", 19, 90.0),
            new Student("David", 21, 65.5),
            new Student("Eve", 20, 88.0)
        );

//    課題
//    ③学生リストから成績が80以上の学生の名前リストを取得して表示してください。
//    ④学生リストから年齢が20以上の学生の平均成績を計算してください。
//    ⑤学生リストから成績が最も高い学生を見つけて表示してください。

//    ③
        String highScoreStudentsList = students.stream()
            .filter(v -> v.getGrade() >= 80)
            .map(Student::getName)
            .collect(Collectors.joining(","));
        System.out.println("80点以上の生徒リスト：" + highScoreStudentsList);

//    ④
        double averageOver20age = students.stream()
            .filter(v -> v.getAge() >= 20)
            .collect(Collectors.averagingDouble(Student::getGrade));
        System.out.println("20歳以上の平均成績：" + averageOver20age);

//    ⑤
        Optional<Student> highestScoreStudent = students.stream()
            .max(Comparator.comparingDouble(Student::getGrade));
        highestScoreStudent.ifPresent(student -> System.out.println("最高得点者：" + student.getName()));

    }
}
