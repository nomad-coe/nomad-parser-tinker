package eu.nomad_lab.parsers

import eu.nomad_lab
import eu.nomad_lab.DefaultPythonInterpreter
import org.{ json4s => jn }
import eu.{ nomad_lab => lab }
import scala.collection.breakOut

object TinkerParser extends SimpleExternalParserGenerator(
  name = "TinkerParser",
  parserInfo = jn.JObject(
    ("name" -> jn.JString("TinkerParser")) ::
      ("parserId" -> jn.JString("TinkerParser" + lab.TinkerVersionInfo.version)) ::
      ("versionInfo" -> jn.JObject(
        ("nomadCoreVersion" -> jn.JObject(lab.NomadCoreVersionInfo.toMap.map {
          case (k, v) => k -> jn.JString(v.toString)
        }(breakOut): List[(String, jn.JString)])) ::
          (lab.TinkerVersionInfo.toMap.map {
            case (key, value) =>
              (key -> jn.JString(value.toString))
          }(breakOut): List[(String, jn.JString)])
      )) :: Nil
  ),
  mainFileTypes = Seq("text/.*"),
  mainFileRe = """\s*#+\s*TINKER\s*---\s*Software\s*Tools\s*for\s*Molecular\s*Design\s*#+\s*""".r,
  cmd = Seq(DefaultPythonInterpreter.pythonExe(), "${envDir}/parsers/tinker/parser/parser-tinker/TINKERParser.py",
    "${mainFilePath}"),
  resList = Seq(
    "parser-tinker/TINKERParser.py",
    "parser-tinker/TINKERDictionary.py",
    "parser-tinker/TINKERCommon.py",
    "parser-tinker/setup_paths.py",
    "nomad_meta_info/public.nomadmetainfo.json",
    "nomad_meta_info/common.nomadmetainfo.json",
    "nomad_meta_info/meta_types.nomadmetainfo.json",
    "nomad_meta_info/tinker.nomadmetainfo.json"
  ) ++ DefaultPythonInterpreter.commonFiles(),
  dirMap = Map(
    "parser-tinker" -> "parsers/tinker/parser/parser-tinker",
    "nomad_meta_info" -> "nomad-meta-info/meta_info/nomad_meta_info",
    "python" -> "python-common/common/python/nomadcore"
  ) ++ DefaultPythonInterpreter.commonDirMapping(),
  metaInfoEnv = Some(lab.meta.KnownMetaInfoEnvs.tinker)
)

