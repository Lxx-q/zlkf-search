/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.app.web.zlkf.search.searchworker.controller.rest;

import king.app.web.zlkf.search.searchworker.service.model.EntryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author king
 */
@RestController
@RequestMapping("api/entry")
public class EntryItemController {
    
    @Autowired
    private EntryItemService entryItemService;
    
    @RequestMapping("search")
    public Object searchText( String text ){
        return this.entryItemService.searchByText(text);
    }
}
