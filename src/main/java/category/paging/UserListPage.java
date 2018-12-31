package category.paging;

import org.springframework.data.domain.Page;


import category.user.User;
import java.util.ArrayList;
import java.util.List;

public class UserListPage {

    private static final int DEFAULT_PAGE = 3;

    private int totalPage;
    private int presentPage;

    public static UserListPage of(Page<User> presentPage) {
        return new UserListPage(presentPage.getTotalPages(), presentPage.getNumber());
    }

    public UserListPage(int totalPage, int presentPage){
        this.totalPage = totalPage;
        this.presentPage = presentPage;
    }

    public List<Integer> getShowPage(){
        List<Integer> pages = new ArrayList<>();

        for (int i = getBlockFirst(); i <=getBlackLast(); i++) {
            pages.add(i);
        }
        
        return pages;
    }

    public int getBlockFirst(){
        return (getBlockNumber(presentPage) -1)*DEFAULT_PAGE;
    }

    public int getBlackLast(){
        return (getBlockFirst() +1) + DEFAULT_PAGE;
    }


    public int getBlockNumber(int presentPage){
        return (int)Math.ceil(presentPage/(double) DEFAULT_PAGE);
    }

    public boolean nextPage(){
        return getBlockNumber(presentPage) < getBlockNumber(totalPage);
    }

    public int getNoPreviousPage(){
        return getBlockFirst()-1;
    }

    public int getNoNextPage(){
        return getBlackLast()+1;
    }

}