package com.fanhua.diary.service;

import com.fanhua.diary.mapper.DiaryMapper;
import com.fanhua.diary.model.Diary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Wrapper;
import java.util.List;

@Service
public class DiaryService {

    @Autowired
    private DiaryMapper diaryMapper;

    public void addDiary(Diary diary) {
        diaryMapper.insert(diary);
    }

    public void deleteDiary(Integer id){
        diaryMapper.deleteById(id);
    }

    public Diary getDiary(Integer id){
       return diaryMapper.selectById(id);
    }

    public void updateDiary(Diary diary) {
        diaryMapper.updateById(diary);
    }

    public List<Diary> getAllDiary(){
        return diaryMapper.selectList(null);
    }


}
