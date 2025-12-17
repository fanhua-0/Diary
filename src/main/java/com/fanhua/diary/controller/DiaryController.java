package com.fanhua.diary.controller;


import com.fanhua.diary.model.Diary;
import com.fanhua.diary.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fanhua.diary.common.Result;

import java.time.LocalDateTime;
import java.util.List;


@RequestMapping("/diary")
@RestController
public class DiaryController {

    @Autowired
    private DiaryService diaryService;

    @PostMapping("/add")
    public Result<Diary> insertDiary(@RequestBody Diary diary){

        LocalDateTime now = LocalDateTime.now();
        diary.setCreateTime(now);
        diary.setUpdateTime(now);
        diaryService.addDiary(diary);
        return Result.success(diary);
    }

    @PostMapping("/delete")
    public Result<Diary> deleteDiary(Integer id){
        if(id == null){
            return Result.error("删除失败，请输入正确Id");
        }

        Diary diary = diaryService.getDiary(id);
        if(diary == null){
            return Result.error("未找到该Id");
        }
        diaryService.deleteDiary(id);
        return Result.success();
    }

    @GetMapping("/get")
    public Result<Diary> getDiary(Integer id){
        if(id == null){
            return Result.error("请传入Id");
        }

        Diary diary = diaryService.getDiary(id);

        if(diary == null){
            return Result.error("数据库里没有 ID 为 \" + id + \" 的日记");
        }

        return Result.success(diary);
    }


    @PostMapping("/update")
    public Result<Diary> updateDiary(@RequestBody Diary diary){
        if(diary == null){
            return Result.error("请输入正确的数据");
        }

        LocalDateTime now = LocalDateTime.now();
        diary.setUpdateTime(now);

        diaryService.updateDiary(diary);
        return Result.success(diary);
    }

    @GetMapping("/getAll")
    public Result<List<Diary>> getAllDiary(){
        return Result.success(diaryService.getAllDiary());
    }


}
