import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatePotionModalComponent } from './create-potion-modal.component';

describe('CreatePotionModalComponent', () => {
  let component: CreatePotionModalComponent;
  let fixture: ComponentFixture<CreatePotionModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CreatePotionModalComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreatePotionModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
