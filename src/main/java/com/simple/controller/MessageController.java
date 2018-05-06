package com.simple.controller;


import com.github.pagehelper.PageInfo;
import com.simple.common.ServerResponse;
import com.simple.pojo.Message;
import com.simple.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Create by S I M P L E on 2018/03/30 00:10:47
 */

@Controller
@RequestMapping(value = "/message/")
public class MessageController {

    private final IMessageService iMessageService;

    @Autowired
    public MessageController(IMessageService iMessageService) {
        this.iMessageService = iMessageService;
    }

    @RequestMapping(value = "upload_website_message.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> uploadWebsiteMessage(String name, String email, String phone, String message) {
        return iMessageService.uploadWebsiteMessage(name, email, phone, message);
    }

    @RequestMapping(value = "get_all_message.do", method = RequestMethod.GET)
    public String getAllMessage(HttpSession session, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        // TODO: 没有权限观看
        ServerResponse<PageInfo> pageInfoMessage = iMessageService.getAllMessage(pageNum, pageSize);
        if (pageInfoMessage.isSuccess()) {
            session.setAttribute("pageInfoMessage",pageInfoMessage);
            return "backstage/messageShow";
        }
        return "error";
    }

    // TODO: 删除消息
}
