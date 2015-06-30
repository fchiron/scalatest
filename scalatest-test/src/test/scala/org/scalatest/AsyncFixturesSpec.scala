/*
 * Copyright 2001-2013 Artima, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.scalatest

import org.scalatest.SharedHelpers.EventRecordingReporter

class AsyncFixturesSpec extends FunSpec {

  describe("AsyncFixtures") {

    it("should fail tests with NotAllowedException when mixed in classis FunSpec") {
      val spec = new FunSpec with AsyncFixtures {
        it("a test") {}
      }
      val rep = new EventRecordingReporter
      spec.run(None, Args(reporter = rep))
      assert(rep.testFailedEventsReceived.size == 1)
      val tfe = rep.testFailedEventsReceived(0)
      assert(tfe.throwable.isDefined)
      assert(tfe.throwable.get.isInstanceOf[exceptions.NotAllowedException])
    }

    it("should fail tests with NotAllowedException when mixed in classis FunSpecLike") {
      val spec = new FunSpecLike with AsyncFixtures {
        it("a test") {}
      }
      val rep = new EventRecordingReporter
      spec.run(None, Args(reporter = rep))
      assert(rep.testFailedEventsReceived.size == 1)
      val tfe = rep.testFailedEventsReceived(0)
      assert(tfe.throwable.isDefined)
      assert(tfe.throwable.get.isInstanceOf[exceptions.NotAllowedException])
    }

    it("should fail tests with NotAllowedException when mixed in classis FunSuite") {
      val suite = new FunSuite with AsyncFixtures {
        test("a test") {}
      }
      val rep = new EventRecordingReporter
      suite.run(None, Args(reporter = rep))
      assert(rep.testFailedEventsReceived.size == 1)
      val tfe = rep.testFailedEventsReceived(0)
      assert(tfe.throwable.isDefined)
      assert(tfe.throwable.get.isInstanceOf[exceptions.NotAllowedException])
    }

    it("should fail tests with NotAllowedException when mixed in classis FunSuiteLike") {
      val suite = new FunSuiteLike with AsyncFixtures {
        test("a test") {}
      }
      val rep = new EventRecordingReporter
      suite.run(None, Args(reporter = rep))
      assert(rep.testFailedEventsReceived.size == 1)
      val tfe = rep.testFailedEventsReceived(0)
      assert(tfe.throwable.isDefined)
      assert(tfe.throwable.get.isInstanceOf[exceptions.NotAllowedException])
    }

    it("should fail tests with NotAllowedException when mixed in classis FeatureSpec") {
      val spec = new FeatureSpec with AsyncFixtures {
        scenario("a test") {}
      }
      val rep = new EventRecordingReporter
      spec.run(None, Args(reporter = rep))
      assert(rep.testFailedEventsReceived.size == 1)
      val tfe = rep.testFailedEventsReceived(0)
      assert(tfe.throwable.isDefined)
      assert(tfe.throwable.get.isInstanceOf[exceptions.NotAllowedException])
    }

    it("should fail tests with NotAllowedException when mixed in classis FeatureSpecLike") {
      val spec = new FeatureSpecLike with AsyncFixtures {
        scenario("a test") {}
      }
      val rep = new EventRecordingReporter
      spec.run(None, Args(reporter = rep))
      assert(rep.testFailedEventsReceived.size == 1)
      val tfe = rep.testFailedEventsReceived(0)
      assert(tfe.throwable.isDefined)
      assert(tfe.throwable.get.isInstanceOf[exceptions.NotAllowedException])
    }

  }

}