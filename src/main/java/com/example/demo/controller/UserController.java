package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserMapper userMapper;

    @Autowired
    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 一覧画面の表示
     */
    @GetMapping
    public String getUsers(Model model) {
        List<User> users = userMapper.selectAll();
        model.addAttribute("users", users);
        return "user/list";
    }

    /**
     * 詳細画面の表示
     */
    @GetMapping("{id}")
    public String getUser(@PathVariable int id, Model model) {
        User user = userMapper.select(id);
        model.addAttribute("user", user);
        return "user/show";
    }

    /**
     * 新規作成画面の表示
     */
    @GetMapping("new")
    public String getUserNew() {
        return "user/new";
    }

    /**
     * 新規作成画面の挿入処理
     */
    @PostMapping
    public String postUserCreate(@ModelAttribute User user) {
        userMapper.insert(user);
        return "redirect:/users";
    }

    /**
     * 編集画面の表示
     */
    @GetMapping("{id}/edit")
    public String getUserEdit(@PathVariable int id, Model model) {
        User user = userMapper.select(id);
        model.addAttribute("user", user);
        return "user/show";
    }

    /**
     * 編集画面の更新処理
     */
    @PutMapping("{id}")
    public String putUserEdit(@PathVariable int id, @ModelAttribute User user) {
        user.setId(id);
        userMapper.update(user);
        return "redirect:/users";
    }

    /**
     * 削除処理
     */
    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable int id, Model model) {
        userMapper.delete(id);
        return "redirect:/users";
    }

}
