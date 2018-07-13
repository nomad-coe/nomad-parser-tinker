/*
 * Copyright 2018-2018 Berk Onat
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

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
