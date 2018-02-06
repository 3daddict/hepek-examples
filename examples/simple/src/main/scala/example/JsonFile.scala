package example

import java.nio.file.Paths
import java.util.UUID
import ba.sake.hepek.core.Renderable

object JsonFile extends Renderable {

  // we EXPLICITLY set path where it should be rendered :)
  override def relPath = Paths.get("json/my-json.json")

  override def render = {
    val people = List(
      Person(UUID.randomUUID(), "Sakib", 25),
      Person(UUID.randomUUID(), "Mirsad", 26),
      Person(UUID.randomUUID(), "Amer", 26),
      Person(UUID.randomUUID(), "Muris", 35)
    )
    val peopleJSON = for (p <- people) yield {
      s"""|{
          |  "id":    "${p.id}",
          |  "name":  "${p.name}",
          |  "age":    ${p.age}
          |}""".stripMargin
    }
    // you get the idea... :)
    s"""|{
        |  "people": [
        |    ${peopleJSON.mkString(",")}
        |  ]
        |}""".stripMargin
  }

  case class Person(id: UUID, name: String, age: Int)

}