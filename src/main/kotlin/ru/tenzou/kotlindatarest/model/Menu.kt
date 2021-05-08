package ru.tenzou.kotlindatarest.model

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "menu")
data class Menu(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "restaurant_id")
    var restaurant: Restaurant?,
    @Column(name = "menu_date", columnDefinition = "DATE")
    var date: LocalDate,
    @Column(name = "menu_title")
    var title: String,
    @Column(name = "menu_text")
    var text: String,
)
