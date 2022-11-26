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

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.template.Engine;

public class DemoConfig extends JFinalConfig {
    /**
     * Run this main method to start the project. This main method can be placed in any Class definition, not necessarily here.
     *
     * After using this method to start for the first time, it will be automatically generated in the debug and run config of the development tool.
     * A startup configuration, additional configuration items can be added to the automatically generated configuration, for example, VM argument can be configured as:
     * -XX:PermSize=64M -XX:MaxPermSize=256M
     */
    public static void main(String[] args) {
        /**
         * Special Note: The recommended startup method under Eclipse.
         */
        // JFinal.start("src/main/webapp", 8080, "/", 5);

        /**
         * Special attention: The suggested starting method under IDEA only has one less last parameter than under eclipse.
         */
        JFinal.start("src/main/webapp", 8080, "/");
    }

    /**
     * configuration constants.
     */
    public void configConstant(Constants me) {
    }

    /**
     * configure routing.
     */
    public void configRoute(Routes me) {
        me.add("/", DemoController.class);
    }

    public void configEngine(Engine me) {
    }

    /**
     * configure plugin.
     */
    public void configPlugin(Plugins me) {
    }

    /**
     * Configure global interceptors.
     */
    public void configInterceptor(Interceptors me) {
        me.add(new HttpBasicAuthnInterceptor());
        me.add(new JCasbinAuthzInterceptor());
    }

    /**
     * configure processor.
     */
    public void configHandler(Handlers me) {
    }
}
