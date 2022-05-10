package io.github.chaosunity

import io.github.chaosunity.ast.{Expression, Statement}

import scala.jdk.CollectionConverters.*
import java.util
import scala.collection.mutable.ArrayBuffer

class Parser(_tokens: util.List[Token]):
  private val tokens: List[Token] = _tokens.asScala.toList
  private var pos: Int = 0

  def peek(): Option[Token] =
    pos match
      case _ if pos < tokens.size => Some(tokens(pos))
      case _ => None

  def next(): Option[Token] =
    val token = peek()
    pos += 1
    token

  def assert(literal: String): Token =
    next() match
      case Some(token) =>
        if !(token eq literal) then
          throw Exception(s"Excepted token $literal but got ${token.getLiteral}")
        else
          token
      case None =>
        throw Exception(s"Expected token $literal but got nothing")

  def assert(tokenType: TokenType): Token =
    next() match
      case Some(token) =>
        if !(token.getType == tokenType) then
          throw Exception(s"Excepted token $tokenType but got ${token.getType}")
        else
          token
      case None =>
        throw Exception(s"Expected token $tokenType but got nothing")

  def parse(): util.List[Statement] =
    val statements = ArrayBuffer[Statement]()

    while pos < tokens.size do
      val currentToken = peek().get

      if (currentToken eq "const") || (currentToken eq "let") then
        val declarationType = next().get.getLiteral match
          case "const" => Statement.VariableDeclaration.DeclarationType.CONST
          case "let" => Statement.VariableDeclaration.DeclarationType.LET
          case _ => throw Exception("Unexpected error")
        val variableName = assert(TokenType.Identifier).getLiteral
        val value = parseExpr()

        statements.addOne(Statement.VariableDeclaration(declarationType, variableName, value))
      else
        pos += 1

    println(statements)

    statements.asJava

  def parseExpr(): Expression =
    if peek().get.getType == TokenType.IntegerLiteral then
      Expression.IntegerVal(assert(TokenType.IntegerLiteral).getLiteral.toInt)
    else
      throw Exception("Unexpected token, expected expression")