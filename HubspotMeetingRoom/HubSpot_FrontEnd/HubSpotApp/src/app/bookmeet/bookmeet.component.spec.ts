import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookmeetComponent } from './bookmeet.component';

describe('BookmeetComponent', () => {
  let component: BookmeetComponent;
  let fixture: ComponentFixture<BookmeetComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BookmeetComponent]
    });
    fixture = TestBed.createComponent(BookmeetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
