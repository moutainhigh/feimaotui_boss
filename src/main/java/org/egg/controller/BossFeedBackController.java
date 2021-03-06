package org.egg.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.egg.biz.FeedBackBiz;
import org.egg.model.DO.FeedBack;
import org.egg.model.VO.FeedBackQueryReq;
import org.egg.response.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dataochen
 * @Description
 * @date: 2019/12/16 11:00
 */
@RequestMapping("/boss/feedBack")
@Controller
@Slf4j
public class BossFeedBackController {
    @Autowired
    private FeedBackBiz feedBackBiz;
    /**
     * 反馈记录页面
     * 管理页面
     *
     * @return
     */
    @RequestMapping("/showFeedBack")
    public String showFeedBack(Model model) {

        return "boss/feedbackManage";
    }
    @RequestMapping("/feedbackList/queryList")
    @ResponseBody
    public Map<String, Object> feedbackList(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            String condition = request.getParameter("condition");
            String pageStr = request.getParameter("page");
            String rowsStr = request.getParameter("rows");
            log.info("查询feedbackList记录开始,查询参数:condition={},page={},rows={}", JSON.toJSONString(condition), pageStr, rowsStr);
            FeedBackQueryReq feedBackQueryReq = JSON.parseObject(condition, FeedBackQueryReq.class);
            feedBackQueryReq.setPageNo(Integer.valueOf(pageStr));
            feedBackQueryReq.setPageNum(Integer.valueOf(rowsStr));
            PageResult pageResult = feedBackBiz.feedBackRecordList(feedBackQueryReq);
            if (pageResult.isSuccess()) {
                List<FeedBack> rows = new ArrayList<>();
                if (CollectionUtils.isEmpty(pageResult.getData())) {
                    log.info("查询feedbackList记录成功,查询参数:condition={},size=0", JSON.toJSONString(condition));
                } else {
                    log.info("查询feedbackList记录成功,查询参数:condition={},size={}", JSON.toJSONString(condition), rows.size());
                    rows = pageResult.getData();
                }
                resultMap.put("total", pageResult.getTotal());
                resultMap.put("rows", rows);
                resultMap.put("success", true);
            }
        } catch (Exception e) {
            log.error("查询feedbackList记录异常,异常详情={}", e);
        }
        return resultMap;
    }
}
