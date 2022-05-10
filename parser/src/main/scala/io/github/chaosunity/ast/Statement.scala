package io.github.chaosunity.ast

abstract class Statement:
  case class VariableDeclaration() extends Statement
