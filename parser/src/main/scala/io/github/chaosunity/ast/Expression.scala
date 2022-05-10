package io.github.chaosunity.ast

abstract class Expression
object Expression:
  case class IntegerVal(value: Int) extends Expression
