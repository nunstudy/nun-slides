package org.nunstudy.pathology



import org.junit.*
import grails.test.mixin.*

@TestFor(AperioNunController)
@Mock(AperioNun)
class AperioNunControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/aperioNun/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.aperioNunInstanceList.size() == 0
        assert model.aperioNunInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.aperioNunInstance != null
    }

    void testSave() {
        controller.save()

        assert model.aperioNunInstance != null
        assert view == '/aperioNun/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/aperioNun/show/1'
        assert controller.flash.message != null
        assert AperioNun.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/aperioNun/list'


        populateValidParams(params)
        def aperioNun = new AperioNun(params)

        assert aperioNun.save() != null

        params.id = aperioNun.id

        def model = controller.show()

        assert model.aperioNunInstance == aperioNun
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/aperioNun/list'


        populateValidParams(params)
        def aperioNun = new AperioNun(params)

        assert aperioNun.save() != null

        params.id = aperioNun.id

        def model = controller.edit()

        assert model.aperioNunInstance == aperioNun
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/aperioNun/list'

        response.reset()


        populateValidParams(params)
        def aperioNun = new AperioNun(params)

        assert aperioNun.save() != null

        // test invalid parameters in update
        params.id = aperioNun.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/aperioNun/edit"
        assert model.aperioNunInstance != null

        aperioNun.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/aperioNun/show/$aperioNun.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        aperioNun.clearErrors()

        populateValidParams(params)
        params.id = aperioNun.id
        params.version = -1
        controller.update()

        assert view == "/aperioNun/edit"
        assert model.aperioNunInstance != null
        assert model.aperioNunInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/aperioNun/list'

        response.reset()

        populateValidParams(params)
        def aperioNun = new AperioNun(params)

        assert aperioNun.save() != null
        assert AperioNun.count() == 1

        params.id = aperioNun.id

        controller.delete()

        assert AperioNun.count() == 0
        assert AperioNun.get(aperioNun.id) == null
        assert response.redirectedUrl == '/aperioNun/list'
    }
}
