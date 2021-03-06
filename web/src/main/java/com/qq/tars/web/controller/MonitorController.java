/*
 * Tencent is pleased to support the open source community by making Tars available.
 *
 * Copyright (C) 2016 THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the BSD 3-Clause License (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * https://opensource.org/licenses/BSD-3-Clause
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.qq.tars.web.controller;

import com.qq.common.WrappedController;
import com.qq.tars.service.monitor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MonitorController extends WrappedController {

    @Autowired
    private TARSStatMonitorService tarsStatMonitorService;

    @Autowired
    private TARSPropertyMonitorService tarsPropertyMonitorService;

    @RequestMapping(
            value = "server/api/tarsstat_monitor_data",
            produces = {"application/json"}
    )
    @ResponseBody
    public List<TARSStatMonitorDataRow> tarsstat(HttpServletRequest request) throws Exception {
        TARSStatMonitorCondition condition = new TARSStatMonitorCondition(request);
        return tarsStatMonitorService.getTARSStatMonitorData(condition);
    }

    @RequestMapping(
            value = "server/api/tarsproperty_monitor_data",
            produces = {"application/json"}
    )
    @ResponseBody
    public List<TARSPropertyMonitorDataRow> tarsproperty(HttpServletRequest request) throws Exception {
        TARSPropertyMonitorCondition condition = new TARSPropertyMonitorCondition(request);
        return tarsPropertyMonitorService.getTARSPropertyMonitorData(condition);
    }

}
