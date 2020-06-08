package jp.te4a.spring.boot.myapp9;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;

//  public BookForm create(BookForm bookForm) {
//    bookForm.setId(bookRepository.getBookId());
//    BookBean bookBean = new BookBean();
//    BeanUtils.copyProperties(bookForm, bookBean);
//    bookRepository.create(bookBean);
//    return bookForm;
//  }

	public BookForm create(BookForm bookForm) {
		BookBean bookBean = new BookBean();
		BeanUtils.copyProperties(bookForm, bookBean);
		bookRepository.save(bookBean);
		return bookForm;
	}

//	public BookForm update(BookForm bookForm) {
//		BookBean bookBean = new BookBean();
//		BeanUtils.copyProperties(bookForm, bookBean);
//		bookRepository.update(bookBean);
//		return bookForm;
//	}

	public BookForm update(BookForm bookForm) {
		BookBean bookBean = new BookBean();
		BeanUtils.copyProperties(bookForm, bookBean);
		bookRepository.save(bookBean);
		return bookForm;
	}

	public void delete(Integer id) {
//		bookRepository.delete(id);
		// no.1
		BookBean bb = new BookBean();
		bb.setId(id);
		bookRepository.delete(bb);

		// no.2
//		Optional<BookBean> ob = bookRepository.findById(id);
//		ob.ifPresent(book -> {
//			bookRepository.delete(book);
//		});

	}

	public List<BookForm> findAll() {
		List<BookBean> beanList = bookRepository.findAll();
		List<BookForm> formList = new ArrayList<BookForm>();
		for (BookBean bookBean : beanList) {
			BookForm bookForm = new BookForm();
			BeanUtils.copyProperties(bookBean, bookForm);
			formList.add(bookForm);
		}
		return formList;
	}

	public BookForm findOne(Integer id) {
//		BookBean bookBean = bookRepository.findOne(id);
//		Optional<BookBean> bookBean = bookRepository.findById(id);
//		BookBean bookBean = new BookBean();
//		bookBean.setId(id);

		BookForm bookForm = new BookForm();
		Optional<BookBean> opt = bookRepository.findById(id);
		opt.ifPresent(book -> {
			BeanUtils.copyProperties(book, bookForm);
		});

		return bookForm;
	}
}
