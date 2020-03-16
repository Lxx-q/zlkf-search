/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.app.web.zlkf.search.searchworker.model.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author king
 */
@Entity
@Table(name = "entry_search_history")
public class EntrySearchHistory {
    
    @Id
    @Column(name="id")
    public Long id = null;
    
    @Column(name="content")
    public String content = null;
    
    @Column(name="create_time")
    public Date createTime = null;
    
    @Column(name="search_count")
    public Long searchCount = null;
}