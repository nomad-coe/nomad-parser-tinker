#
# Copyright The NOMAD Authors.
#
# This file is part of NOMAD. See https://nomad-lab.eu for further info.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

import pytest

from nomad.datamodel import EntryArchive
from tinkerparser import TinkerParser


def approx(value, abs=0, rel=1e-6):
    return pytest.approx(value, abs=abs, rel=rel)


@pytest.fixture(scope='module')
def parser():
    return TinkerParser()


def test_basic(parser):
    archive = EntryArchive()

    parser.parse('tests/data/argon/argon.log', archive, None)

    sec_run = archive.section_run[0]
    assert sec_run.program_version == 'Version 8.0'

    sec_systems = archive.section_run[0].section_system
    assert len(sec_systems) == 6
    assert sec_systems[1].lattice_vectors[1][1].magnitude == approx(2.60206e-09)
    assert sec_systems[2].atom_labels[149] == 'Ar'
    assert sec_systems[4].atom_positions[3][2].magnitude == approx(-5.504464e-10)

    sec_sccs = sec_run.section_single_configuration_calculation
    assert len(sec_sccs) == 30
    assert sec_sccs[5].energy_total.magnitude == approx(-5.42430901e-19)


def test_1(parser):
    archive = EntryArchive()

    parser.parse('tests/data/ice/ice.log', archive, None)

    sec_systems = archive.section_run[0].section_system
    assert len(sec_systems) == 2
    assert sec_systems[0].lattice_vectors[2][0].magnitude == approx(-1.412639061e-09)
    assert len(sec_systems[0].atom_positions) == 3024
    assert sec_systems[0].atom_labels[3017] == 'H'
    assert sec_systems[0].atom_positions[2985][0].magnitude == approx(-1.4647033e-09)
    assert sec_systems[1].atom_positions[2][0].magnitude == approx(5.613374e-10)
