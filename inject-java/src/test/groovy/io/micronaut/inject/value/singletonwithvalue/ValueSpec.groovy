/*
 * Copyright 2017-2018 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.inject.value.singletonwithvalue

import io.micronaut.context.ApplicationContext
import io.micronaut.context.ApplicationContext
import io.micronaut.context.DefaultApplicationContext
import spock.lang.Specification

class ValueSpec extends Specification {

    void "test configuration injection with @Value"() {
        given:
        ApplicationContext context = ApplicationContext.run(
                "foo.bar":"8080"
        )
        A a = context.getBean(A)
        B b = context.getBean(B)

        expect:
        a.port == 8080
        a.optionalPort.get() == 8080
        !a.optionalPort2.isPresent()
        a.fieldPort == 8080
        a.anotherPort == 8080
        a.defaultPort == 9090
        b.fromConstructor == 8080
        b.a != null

    }
}
