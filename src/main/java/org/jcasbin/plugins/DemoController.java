// Copyright 2018 The casbin Authors. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.jcasbin.plugins;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

@Before(JCasbinAuthzIntercepter.class)
public class DemoController extends Controller {
    public void index() {
        String path = getRequest().getRequestURI();
        String method = getRequest().getMethod();
        renderText(String.format("OK, path = %s, method = %s", path, method));
    }
}
