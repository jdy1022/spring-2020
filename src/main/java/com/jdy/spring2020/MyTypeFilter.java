package com.jdy.spring2020;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyTypeFilter implements TypeFilter {


    /**
     *
     * @param metadataReader:读取到当前正在扫描的类的信息
     * @param metadataReaderFactory :获取其他类（如超类和接口）的元数据读取器的工厂
     * @return  match方法返回值true:表示规则匹配成功 false:表示规则匹配失败
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前正在扫描的类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取类名
        String className = classMetadata.getClassName();
        //获取当前类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前类型资源信息（路径信息）
        Resource resource = metadataReader.getResource();
        //
        if(className.contains("Service")){
            return true;
        }
        return false;
    }
}
