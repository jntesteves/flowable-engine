/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.flowable.engine.test.bpmn.event;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.ExecutionListener;
import org.flowable.engine.impl.test.PluggableFlowableTestCase;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.engine.test.Deployment;

public class IntermediateNoneEventTest extends PluggableFlowableTestCase {

    private static boolean listenerExecuted;

    public static class MyExecutionListener implements ExecutionListener {
        public void notify(DelegateExecution execution) {
            listenerExecuted = true;
        }
    }

    @Deployment
    public void testIntermediateNoneTimerEvent() throws Exception {
        assertFalse(listenerExecuted);
        ProcessInstance pi = runtimeService.startProcessInstanceByKey("intermediateNoneEventExample");
        assertProcessEnded(pi.getProcessInstanceId());
        assertTrue(listenerExecuted);
    }

}