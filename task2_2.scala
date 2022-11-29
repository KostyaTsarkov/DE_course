package playground
import playground.ScalaPlayground.{aList, buf}

import scala.io.StdIn.readLine

object task2_2 extends App {

  val aString = "Hello, Scala!"

  //печатает на экран фразу «Hello, Scala!».
  println(aString)

  //выводит фразу «Hello, Scala!» справа налево
  println(aString.reverse)

  //переводит всю фразу в нижний регистр
  println(aString.toLowerCase)

  //удаляет символ!
  println(aString.replace("!",""))

  //добавляет в конец фразы «and goodbye python!»
  println(aString :++ " and goodbye python!")

  //вычисляет ежемесячный оклад сотрудника после вычета налогов
  println("Введите годовой доход до вычета налогов")
  val Salary = readLine().toFloat
  println("Введите размер премии – в процентах от годового дохода")
  val Bonus = readLine().toFloat
  println("Введите компенсацию питания")
  val Eat = readLine().toFloat
  val SalaryMonth = (Salary + Salary*Bonus/100)-((Salary + Salary*Bonus/100)*0.13) - Eat
  println("Ежемесячная зарплата: " + SalaryMonth)

  //рассчитывает для каждого сотрудника отклонение(в процентах) от среднего значения оклада на уровень всего отдела
  var aList = List(100,150,200,80,120,75)
  val SalaryMean = aList.sum/aList.size
  println("Отклонение: " + ((SalaryMonth - SalaryMean)/SalaryMean*100).round.toString :+'%')

  //рассчитать новую зарплату сотрудника
  val SalaryNew = (SalaryMonth + (SalaryMonth - SalaryMean)/SalaryMean).round
  aList = SalaryNew.toInt::aList
  println("Новая зарплата: " + aList)

  // отсортировать список сотрудников по уровню оклада
  val aListNew = List(350,90)
  aList = (aList:::aListNew).sorted
  println("Осортированный список: " + aList)

  //вычислите самостоятельно номер сотрудника в списке
  import scala.collection.mutable.ListBuffer
  var buf = new ListBuffer[Int]()
  buf ++= aList
  val aFind = buf.find(_ > 130).get
  val aIndexGet = buf.indexOf(aFind)
  buf.insert((aIndexGet - 1), 130)
  println("Новый список: " + buf.toList)

  //вывести номера сотрудников из полученного списка, которые попадают под категорию middle

  println("Введите вилку зарплат - минимальное")
  val aMin = readLine().toInt
  println("Введите вилку зарплат - максимальное")
  val aMax = readLine().toInt
  var buf2 = new ListBuffer[Int]()
  buf2 ++= aList
  val aFindMin = buf2.find(_ >= aMin).get
  val aIndexMin = buf2.indexOf(aFindMin)
  val aFindMax = buf2.find(_ > aMax).get
  val aIndexMax = buf2.indexOf(aFindMax)
  println("Диапозон индексов: " + aIndexMin, aIndexMax - 1)

  //проиндексировать зарплату каждого сотрудника на уровень инфляции – 7%

  println("Проиндексированные зарплаты: " + aList.map(s => s+(s * 0.7)))
}
