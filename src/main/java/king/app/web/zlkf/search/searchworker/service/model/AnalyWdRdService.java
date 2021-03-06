/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.app.web.zlkf.search.searchworker.service.model;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import king.app.web.zlkf.search.searchworker.model.bean.AnalyWordRecord;
import king.app.web.zlkf.search.searchworker.model.jpa.AnalywdRdRepository;
import king.app.web.zlkf.search.searchworker.service.model.obj.EqualSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 *
 * @author king
 */
@Service
public class AnalyWdRdService {

    @Autowired
    private AnalywdRdRepository repository;

    public Set<AnalyWordRecord> searchOrInsert(Set<String> strSet) {

        Set<AnalyWordRecord> recordSet = new HashSet<AnalyWordRecord>();

        for (String str : strSet) {

            AnalyWordRecord record = this.findOrInsert(str);
            //将值输入
            if (record != null) {
                recordSet.add(record);
            }

        }

        return recordSet;

    }

    /**
     *  接下去准备开始查询或者删除
     * @param str
     * @return 
     */
    public AnalyWordRecord findOrInsert(String str) {
        Specification<AnalyWordRecord> specification = new EqualSpecification<AnalyWordRecord>("word",str);
        Optional<AnalyWordRecord> optional = this.repository.findOne( specification );
        boolean isPresent = optional.isPresent();
        AnalyWordRecord record = null;
        if (isPresent) {
            //若存在，则直接获取 
            record = optional.get();
        } else { //若否，则直接新建对应的数据信息
            record = this.newObj(str);
        }

        if (record == null) {
            return record;
        }
        //添加进入目标地址

        return record;
    }

    /**
     * 根据对应的str字符串来生成对应的 analyword 信息
     *
     * @param str
     * @return
     */
    public AnalyWordRecord newObj(String str) {
        AnalyWordRecord record = new AnalyWordRecord();

        //输入对应的信息
        Long current = System.currentTimeMillis();
        record.id = current;
        record.createTime = current;
        record.modifyTime = record.createTime;
        record.word = str;
        
        //this.repository.findOne( new EqualSpecification<AnalyWordRecord>("",""));

        record = this.repository.save(record);

        return record;
    }

}
