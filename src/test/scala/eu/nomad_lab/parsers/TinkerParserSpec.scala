package eu.nomad_lab.parsers

import org.specs2.mutable.Specification

object TinkerParserTests extends Specification {
  "TinkerParserTest" >> {
    "[Anion in Water (xyz sequence of outputs with 643 atoms)] test with json-events" >> {
      ParserRun.parse(TinkerParser, "parsers/tinker/test/examples/anion/anion.log", "json-events") must_== ParseResult.ParseSuccess
    }
    "[Anion in Water (xyz sequence of outputs with 643 atoms)] test with json" >> {
      ParserRun.parse(TinkerParser, "parsers/tinker/test/examples/anion/anion.log", "json") must_== ParseResult.ParseSuccess
    }
    "[Ice (.arc trajectory with 3024 atoms)] test with json-events" >> {
      ParserRun.parse(TinkerParser, "parsers/tinker/test/examples/ice/ice.log", "json-events") must_== ParseResult.ParseSuccess
    }
    "[Ice (.arc trajectory with 3024 atoms)] test with json" >> {
      ParserRun.parse(TinkerParser, "parsers/tinker/test/examples/ice/ice.log", "json") must_== ParseResult.ParseSuccess
    }
  }
}
